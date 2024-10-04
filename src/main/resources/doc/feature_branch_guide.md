# Step-by-Step Instructions for Creating a Feature Branch

### Step 1: Clone the Repository
First, clone the repository from GitHub to your local machine:

```bash
git clone https://github.com/hbarton2/cscd350-f24-TeamNull.git
```

This command will create a directory called \`cscd350-f24-TeamNull\` containing the repository.

### Step 2: Change Directory to the Repository
Navigate to the repository directory:

```bash
cd cscd350-f24-TeamNull
```

### Step 3: Checkout the \`develop\` Branch
Switch to the \`develop\` branch to ensure you're working from the latest development code:

```bash
git checkout develop
```

### Step 4: Create a Feature Branch
Create a new feature branch for your work, replacing \`<username-task>\` with your specific feature name:

```bash
git switch -c feature/<username-task>
```

For example, if your name is Jimmy and you're working on a task, the command would be:

```bash
git switch -c feature/Jimmy-task
```

### Step 5: Push the Feature Branch to GitHub
Push your new feature branch to the remote repository:

```bash
git push origin feature/<username-task>
```

For example:

```bash
git push origin feature/Jimmy-task
```

This command will create the feature branch on the remote repository, allowing the team to track your progress.

### Step 6: Work on Your Feature
Now you can start working on your tasks in the \`feature/<username-task>\` branch. Make commits as needed:

```bash
git add .
git commit -m "Description of the changes you made"
```

---

## Summary of Commands
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/hbarton2/cscd350-f24-TeamNull.git
   ```
2. **Navigate to the Directory**:
   ```bash
   cd cscd350-f24-TeamNull
   ```
3. **Checkout the \`develop\` Branch**:
   ```bash
   git checkout develop
   ```
4. **Create a Feature Branch**:
   ```bash
   git switch -c feature/<username-task>
   ```
5. **Push the Feature Branch**:
   ```bash
   git push origin feature/<username-task>
   ```

These steps will ensure that each team member creates a branch for their individual tasks, and all branches are tracked on the remote repository for easier collaboration. Reach out for help if face any issues!
