---
title : "Ballerina Actions"
description : Learn how to use the setup-ballerina GitHub Action to simplify Ballerina workflow on GitHub.
keywords : GitHub Actions, Ballerina, Continuous Integration, Continuous Delivery, CI/CD, GitHub
weight : 50110
canonicalUrl : https://dev.to/hasitha/simplify-ballerina-workflow-on-github-with-setup-ballerina-action-452j
canonicalSite : "**Dev.to Community** blog"
date : 2023-02-20
images : [/docs/devops/github/ballerina-action/action.png]
ballerina_feature : [cicd, github ]
menu:
  main:
    name : "Ballerina Github Actions"
    parent: "guides"
    params:
        group: "devops"
---

# Simplify Ballerina Workflow on GitHub with setup-ballerina Action

The post covers the use of the `setup-ballerina` GitHub Action to automate the installation of the Ballerina (Swan Lake) distribution in the GitHub Action environment.

The following code block shows how you can configure the GitHub Action to build your Ballerina project. You can find a working example of this in this [repository](https://github.com/hasithaa/example-setup-ballerina/).

![`setup-ballerina` in action](/docs/devops/github/ballerina-action/action.png)
{.tip-50-frame}

* The `setup-ballerina` GitHub Action `v1` release requires a mandatory input of the Ballerina Swan Lake distribution version in the form of "Swan Lake channel" as listed in the `bal dist list` command. i.e. `2201.3.0`, `2201.3.2`, etc. This will install Ballerina on workflow environment and `bal` command is added to the `PATH`.
* This action is supported on Ubuntu, MacOS, and Windows, and facilitates easy integration of Ballerina into your GitHub workflow.
* After you install Ballerina command, you can use `run` to execute the `bal` command.

---

With the introduction of `setup-ballerina`, users now have the option to choose between [`ballerina-action`](https://github.com/marketplace/actions/ballerina-action) and [`setup-ballerina`](https://github.com/marketplace/actions/setup-ballerina-language) for using Ballerina in their GitHub Actions workflows.

This provides greater flexibility and choice for users, allowing them to choose the option that best suits their specific workflow needs. A comparison of the two options can help users make an informed decision based on factors such as Architecture and full `bal` command support.

| GitHub Action                | `setup-ballerina` | `ballerina-action`                    |
|------------------------------|-------------------|---------------------------------------|
| Architecture                 | Composite Actions | Docker container                      |
| Supported Ballerina Versions | Swan Lake         | 1.x and Swan Lake                     |
| Full `bal` Command Support   | Yes               | Limited to `bal build` and `bal push` |
{.tip-table}

In summary, setup-ballerina provides more flexibility and full bal command support. The choice of which action to use ultimately depends on your specific needs and workflow requirements.

---

Originally, [setup-ballerina](https://github.com/hasithaa/setup-ballerina/) was one of my pet projects that have now been officially part of the [Ballerina platform](https://github.com/ballerina-platform/setup-ballerina/).