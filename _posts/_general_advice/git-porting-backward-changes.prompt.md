Please write a github pages markdown blogpost that discusses without too fluffy language. For my soft-wa.re blog.

Why you would want to?

You have changes that have been sent to develop, that you also want to go to production, right now, a hotfix or offcycle or what have you.

## Instructions on how to Cherrypick changes from Develop branch


The first thing you need to do is check out the branch you want to commit your changes you. For example Let's say you want to commit your changes to release/3.14.0. So run 

`git switch release/3.14.0`

This is the branch you want your fix to be in.  But you have your work idealy in 2 places

1. All of your original commits, scratch work and all in the feature branch
2. Your final answer squashed down in the `develop` branch

Run `git log --all --decorate --oneline --graph #I remember that by All Dogs...`

You'll see a graph that looks like this. Imagine you are looking for Commit D.

         +-D1-D2 (feature branch)
        /
A---B---C---D---E (main branch)
\
 +--F--G (release/3.14.0-branch)

run `git cherry-pick D`

Apply your commit message.
Push Up to `release/3.14.1`
And that should be that for preping your branch.