import os
import frontmatter
import csv

md_path = './markdown_files'  # Directory containing markdown files
tsv_file = 'data.tsv'  # TSV file path

# Collect metadata from markdown files
metadata_list = []
for filename in os.listdir(md_path):
    if filename.endswith('.md'):
        with open(os.path.join(md_path, filename), 'r') as f:
            post = frontmatter.load(f)
            metadata = post.metadata
            metadata['filename'] = filename
            metadata_list.append(metadata)

# Write to TSV file
with open(tsv_file, 'w', newline='') as file:
    writer = csv.DictWriter(file, fieldnames=metadata_list[0].keys(), delimiter='\t')
    writer.writeheader()
    writer.writerows(metadata_list)
