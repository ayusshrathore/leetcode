import { Octokit } from "@octokit/rest";

import * as fs from "fs";

async function fetchContributors(owner: string, repo: string): Promise<string[]> {
	const octokit = new Octokit();
	const contributorsResponse = await octokit.repos.listContributors({ owner, repo });
	const contributors = contributorsResponse.data.map((contributor) => contributor.login);

	return contributors.filter((contributor) => contributor !== undefined) as string[];
}

function generateContributorsTable(contributors: string[]): string {
	const tableRows = contributors
		.map((contributor) => {
			const avatarUrl = `https://github.com/${contributor}.png`;
			const profileUrl = `https://github.com/${contributor}`;
			return `<td align="center">
          <a href="${profileUrl}">
            <div style="position: relative;">
              <img src="${avatarUrl}" width="100px;" alt="${contributor}" style="border-radius: 50%;" title="${contributor}" />
              <div style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; display: flex; justify-content: center; align-items: center; background-color: rgba(0, 0, 0, 0.7); color: white; opacity: 0; transition: opacity 0.3s;">
                <sub style="font-weight: bold;">${contributor}</sub>
              </div>
            </div>
          </a>
        </td>`;
		})
		.join(" ");

	return `
<table>
  <tr>
    ${tableRows}
  </tr>
</table>`;
}

async function main() {
	const owner = "aaaravv";
	const repo = "leetcode";

	try {
		const contributors = await fetchContributors(owner, repo);
		const contributorsTable = generateContributorsTable(contributors);

		const readmePath = "README.md";
		const readmeContent = fs.readFileSync(readmePath, "utf-8");

		const updatedReadmeContent = readmeContent.replace(
			/<!-- CONTRIBUTORS_START -->[\s\S]*<!-- CONTRIBUTORS_END -->/,
			`<!-- CONTRIBUTORS_START -->\n${contributorsTable}\n<!-- CONTRIBUTORS_END -->`
		);

		fs.writeFileSync(readmePath, updatedReadmeContent, "utf-8");
		console.log("Contributors table updated successfully!");
	} catch (error: any) {
		console.error("Error:", error.message);
	}
}

main();
