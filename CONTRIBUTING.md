# Contributing to [leetcode](https://github.com/ayusshrathore/leetcode)

Thank you for considering contributing to [Your Repository Name]! We welcome contributions from the community to help improve and grow this project. To get started, please follow the guidelines below.

## Getting Started

-   Make sure you have a [GitHub account](https://github.com/signup) if you don't already.
-   Fork this repository to your GitHub account by clicking the **Fork** button at the top right of this page.
-   Clone the forked repository to your local machine:

```bash
git clone https://github.com/ayusshrathore/leetcode
```

-   Create a new branch for your changes:

```bash
git checkout -b my-new-branch
```

-   Make your changes to the project and commit them. Please follow the [commit message guidelines](#commit-message-guidelines).

-   Push your changes to GitHub:

```bash
git push origin my-new-branch
```

-   Open a pull request in this repository by clicking the **Pull Request** button at the top right of this page.

-   Wait for your pull request to be reviewed and merged.

## Commit Message Guidelines

### Type

-   **feat:** Use when adding new features or problems.
-   **fix:** Use when fixing bugs.
-   **refactor:** Use when refactoring code or making improvements.
-   **docs:** Use when updating documentation.
-   **test:** Use when adding or modifying tests.
-   **chore:** Use for routine tasks, maintenance, or non-code changes.

### Brief Description

Provide a concise description of the change, starting with a verb in the imperative mood (e.g., "Add solution for problem XYZ," "Fix issue with ABC").

### Optional Body

Include a more detailed explanation if the brief description is not sufficient. Describe the problem, solution, and relevant context. You can use bullet points or paragraphs for clarity.

### Optional Footer

-   Reference related issues or pull requests using `Closes #issue-number` or `Fixes #issue-number` to automatically close them when the commit is merged.
-   Include any breaking changes or important information for other contributors.

#### Examples

-   Adding a new LeetCode problem:

    ```
    feat: Add solution for problem 123
    ```

-   Fixing a bug in an existing solution:

    > Correct an edge case handling bug in the Python solution.
    > Fixes #456

    ```
    fix: Fix issue with solution for problem 456
    ```

-   Refactoring an existing solution:

    > Simplify algorithm logic for problem 789.

    > Enhance code comments for clarity.

    ```
    refactor: Improve code structure in solution for problem 789
    ```

-   Updating documentation:

    ```
    docs: Update README with instructions for contributions
    ```

> **Note**: For more information on commit message guidelines, see [conventionalcommits](https://www.conventionalcommits.org/en/v1.0.0/).

## Organizing and Solving Problems

<!-- create an nice looking path list -->

-   Browse through the existing sections in the repository to find the topic or category where you'd like to contribute.

-   If you're adding a new problem, make sure it's not already in the repository to avoid duplicates. If it's not already in the repository, create a new folder with a README.md file inside it. The README.md file should contain a brief description of the problem, a link to the problem on LeetCode, and a link to the solution.

-   Create a new directory under the appropriate section for your problem (e.g., arrays, strings, trees, etc.).

-   Add your problem's code in a language-specific subdirectory within the problem's directory (e.g., python, java, cpp, etc.).

-   Include a clear and concise solution description in Markdown format. You can create a separate Markdown file within the problem's directory or add it as comments in your code.

-   Ensure your code follows the coding conventions and style guide of the repository.
