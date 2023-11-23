import csv
import os
import frontmatter

md_path = './markdown_files'  # Directory containing markdown files
tsv_file = 'data.tsv'  # TSV file path

# Read TSV file
metadata_dict = {}
with open(tsv_file, 'r') as file:
    reader = csv.DictReader(file, delimiter='\t')
    for row in reader:
        metadata_dict[row['filename']] = row

# Update markdown files
for filename, metadata in metadata_dict.items():
    md_file = os.path.join(md_path, filename)
    if os.path.exists(md_file):
        with open(md_file, 'r') as f:
            post = frontmatter.load(f)
            post.metadata = metadata
            post.metadata.pop('filename', None)  # Remove filename from metadata

        with open(md_file, 'w') as f:
            frontmatter.dump(post, f)
