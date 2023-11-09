Please write a github pages markdown blogpost about "migrating a team to a new repo" 

1. Let's assume we are migrating a team from bitbucket to github
1.b origin
1.c originGithub
2. Let's assume we want a copy of all the branches in the old repo on the new repo.
2.a. /main
2.b. /develop
2.c. /release/2023-20-0
2.d. /feature/ABC-123

3. Let's provide scripts to do the heavy lifting
3.a. One script that will do the work of porting the branches
3.b. Another script that will update the remotes on developer machines so they don't have to re-clone their repos.
