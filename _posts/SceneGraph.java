//  The SceneGraph class is the base class of scene graph nodes:
//  objects that define a 2D graphical scene in terms of geometric
//  shapes, transformations and compositions.
//
public abstract class SceneGraph {
    void accept(SceneGraphVisitor v);
}

//  Interface for visitors that process scene graphs.
public interface SceneGraphVisitor {
    void visit(Primitive sg);
    void visit(Transform sg);
    void visit(Composite sg);
}

//  A Transform nodes applies an affine transformation to
//  another scene graph (DecoratorPattern).
//
public class Transform implements SceneGraph {
    public SceneGraph getTransformedGraph() { /**/ }

    public Matrix getMatrix() { /**/ }
}

//  A Primitive represents a geometric shape
//
public class Primitive implements SceneGraph {
    public boolean contains(Point2D p) { /**/ }
}

//  A Picker find the shape containing a point.
//
public class Picker implements SceneGraphProcessor {
    private Point2D _point;
    private Primitive _picked = null;

    private class PickFailure extends RuntimeException {
        NoninvertibleMatrixException cause;

        PickFailure(NoninvertibleMatrixException ex) {
            cause = ex;
        }
    }

    //  Client code only accesses the Picker class through this function.
    //  Exceptions are tunneled to this function inside the PickFailed
    //  exception.
    //
    public static Primitive pick(SceneGraph sg, Point2D p) throws NoninvertibleMatrixException {
        try {
            Picker picker = new Picker(p);
            sg.accept(picker);
            return picker._picked;
        } catch (PickFailure ex) {
            throw ex.cause;
        }
    }

    //  Constructor is private: class is accessed through static function
    private Picker(Point2D pick) {
        _point = pick;
    }

    public void visit(Primitive p) {
        if (p.contains(_point)) _picked = p;
    }

    //  Process Transform's by transforming the picked point by the
    //  inverse of the transform, and then picking the transformed
    //  graph with the new point.  Inverting a transform can fail,
    //  so the NoninvertibleMatrixException must be tunneled up to the
    //  code that created and used this visitor (the static pick method).
    public void visit(Transform t) {
        Point2D old_point = _point;
        try {
            Matrix m = transform.getMatrix().inverse();
            _point = m.transform(_point);
        } catch (NoninvertibleMatrixException ex) {
            throw new PickFailure(ex);
        }

        transform.getTransformedGraph().accept(this);
        _point = old_point;
    }

}