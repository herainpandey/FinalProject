pipeline{
  agent any
  stages{
    stage('Build jar'){
        steps{
         sh "mvn clean package -DskipTests"
         }
    }
    stage('Build image'){
        steps{
                 sh "docker build -t=selenium/docker01 ."
                 }
    }stage('Push image'){
        environment{
               DOCKER_HUB = credentials('dockerhub-creds')
        }
        steps{
               sh 'docker push ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin'
               sh 'docker push selenium/docker01'
               sh 'docker tag selenium/docker01:latest selenium/docker01:{$env.BUILD_NUMBER}'
               sh 'docker push selenium/docker01:{$env.BUILD_NUMBER}'
              }
    }
  }

  post{
  always{

  sh "docker logout"
  }
  }
}