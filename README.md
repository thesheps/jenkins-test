# Description

This noddy repo demonstrates how to use a local, scripted `pipeline.groovy` file to specify a bunch of common stages that can be subsequently used by different `Jenkinsfiles`, and PARAMETERISED!!!

Of note:

- Use `scripted pipelines` to do this. It is the only way.
- To use `scripted pipelines`, use the `node` syntax, rather than `pipeline`.
- To select the correct agent, specify this in the `node` block, eg:

```groovy
node("eu-west-1 allows-python") {
    // Stuff here
}
```

- `scm checkout` ensures that all the local files needed for the run are available for the workflow. This is implied in declarative pipelines, but you have to be explicit here to make the pipeline.groovy file available.
- Make sure when you're chaining builds that you set `wait: false` otherwise your builds _will_ glom onto Jenkins executors and prevent other builds from passing.

Some code for ye:

```
docker run -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
```

This'll get you set up with a local jenkins running on :8080 - By far the quickest solution to testing this issue.
