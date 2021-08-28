#!/bin/sh

docker run -it -v "$(pwd):/home/testuser/workspace/InputProject" blog_to_podcast ../BlogCast/main.py
# docker run -it -v "$(pwd):/home/testuser/workspace/InputProject" blog_to_podcast bash
