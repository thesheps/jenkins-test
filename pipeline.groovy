def deploy (env) {
    stage("Deploy to ${env}") {
        sh "echo 'DEPLOYING TO ${env}, YO!'"
    }
}

def promote(env) {
    stage("Promote to ${env}") {
        input("Proceed to ${env}?")
        build(job: "${env}-deploy/master", wait: false)
    }
}

return this