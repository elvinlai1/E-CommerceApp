# E-CommerceApp
Android App 


# Github

## FYI 
github is a hosting service for git.
git is a program.
git documentation <https://git-scm.com/>

## Version control

Please commit changes to the "dev" branch for testing and screwing up only.
We **must** ensure dev is stable before sending it to master branch to prevent complete loss of code and other problems.

## Setting up Github

https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/connecting-to-github-with-ssh

## Git Hub Commands

We will manually update the master branch, so all commands will apply to the "dev" branch

<br>

### Config Github global credentials on local machine

- `git config --global user.name` "[github username]"
- `git config --global user.email` "[github email]"
 
### Setup Github on local machine
 
- `git clone [URL]` //copies all the files over without needing authorization
- `git pull origin dev` //Enter this command AFTER
- `git clone` to retrieve and synchronize changes

### Commiting Changes Process

1. Save the files you have edited
2. `git add [file name]` // Add the **specified** file to a basket before commiting
3. `git add .` // Adds all the files in your current directory to the basket
4. `git commit -m "[message]"` // Commit changes to local git repository (not github)
5. `git push` //pushes the basket full of changes to this github repository. (Note: You must pull all changes before being able to push anything)

- Note: `git push --set-upstream` //If issues arise, doing this command once should allow you to do `git push` and `git pull` without extra commands

### Retrieving Changes

- `git pull` //enter this command in the root folder

### Following Changes
 
- `git log` // lists version history for the current branch.
- `git checkout` //Shows all the files in after executing `git add` command
- `git commit` //messages are displayed clearly here

### Branch Management

- `git status` //show.
- `git branch` //shows which branch you are on
- `git checkout [branch name]` //changes and updates your working directory to that branch
