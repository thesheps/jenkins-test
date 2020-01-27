def deploy (env) {
    stage("Deploy to ${env}") {
        sh "echo 'Deploying to ${env}...'"
    }
}

return this