---
layout: post
title:  "Basics of Docker"
tags: [Programing, GeneralAdvice, Docker, Tools]
permalink: /basics-of-docker/
---

I am brand new to docker, so I though I might start documenting docker from the perspective of a beginner.  I will come back and correct any bad info as necessary.

1. Docker data structures are similar to git.  If you understand the git ([Merkle Trees](https://en.wikipedia.org/wiki/Merkle_tree)), then you would understand the docker data structure.

2. Assuming you want to start a docker image, you are gonna need a command like this. The 'i' stands for interactive. 't' stands for tty.

```bash
docker run -it ubuntu bash
```

3. Running a GUI
Some of the guides out there I found to be a little complex if you are looking for something easily copy-and-pasteable.

```bash
#Host machine
XAUTH_COOKIE=$(xauth list | head -n 1 | sed -e s/:/$(echo $DISPLAY)/g)
docker run -it --net=host -e DISPLAY -e XAUTH_COOKIE="$XAUTH_COOKIE" -v /tmp/.X11-unix ubuntu bash

#Docker container
apt update; apt install -y xauth; xauth add $XAUTH_COOKIE;

#Test it. Make sure you don't have pinta on your host machine running otherwise X seems to get confused and create a new window for your host install of pinta.
apt install -y pinta; pinta
```

4. Sharing data with the host


docker run -v ~/dockerworkspace:/workspace ubuntu

```bash

docker run -it --user $(id -u):$(id -g) -v ~/hostdir:/containerdirectory -v /etc/passwd:/etc/passwd -v /etc/group:/etc/group ubuntu
```

```
docker run -it -v ~/hostdir:/containerdirectory -v /etc/passwd:/etc/passwd -v /etc/group:/etc/group -v /etc/shadow:/etc/shadow ubuntu
```

```
USERARGS="-v /etc/passwd:/etc/passwd -v /etc/group:/etc/group -v /etc/shadow:/etc/shadow"
userargs=( $USERARGS )
docker run -it -v ~/hostdir:/containerdirectory "${userargs[@]}" ubuntu
```


https://stackoverflow.com/q/27925006


While researching a solution to this problem, I have found the following article to be a great resource: https://medium.com/@mccode/understanding-how-uid-and-gid-work-in-docker-containers-c37a01d01cf

In my scripts, the solution boiled down to the following :

docker run --user $(id -u):$(id -g) -v /hostdirectory:/containerdirectory -v /etc/passwd:/etc/passwd myimage

Of course, id -u can be replaced by other means of retrieving a user's gid, such as stat -c "%u" /somepath

