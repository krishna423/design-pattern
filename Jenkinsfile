#!groovy
def jobName = 'test-project'
node{

    deleteDir()

    stage('Pre Build'){
        try{
            checkout scm
            echo "Cloning code from git branch ${env.BRANCH_NAME}"
        }
        catch (exc){
            echo "unable to pull code from branch ${env.BRANCH_NAME}"
            throw exc
        }
        try{
            echo "running prebuild.sh"
            sh 'docker/prebuild.sh'
        }
        catch (exc){
            echo "prebuild.sh failed to run"
            throw exc
        }
    }

    stage('Build'){
        try{
            withMaven(maven: 'Maven', jdk:'java8') {
                echo "Running Build Environment"
                sh 'docker/build.sh'
            }
        }
        catch (exc){
            echo "Build failed"
            throw exc
        }
    }

    stage('Package'){
        try{
            echo 'creating docker image'
            gitCommit = gitCommitId()
            sh "docker/package.sh ${gitCommit}"
            echo 'Docker Image created successfully'
        }
        catch (exc){
            echo "Docker Image creation failed"
            throw exc
        }
    }

    stage('Push'){
        try{
            echo "Pushing the image to repo"
            gitCommit = gitCommitId()
            sh "docker/push.sh ${gitCommit}"
            echo "Docker image pushed successfully in the repo"
        }
        catch(exc){
            echo "Unable to push image to repo"
            throw exc
        }
    }

    stage("deployment"){
        try{
            echo "deployed successfully"
        }
        catch(exc){
            echo "Unable to deploy "
            throw exc
        }
    }

}

def gitCommitId(){
    gitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    shortCommit = gitCommit.take(6)
    return shortCommit
}

def getVersion(){
    version = sh(returnStdout: true, script: 'cut -d- -f1 ./target/classes/version').trim()
    return version
}