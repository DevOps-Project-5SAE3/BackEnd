pipeline {
    agent any


    stages {
        stage('GETTING CODE FROM GIT') {
            steps {
                script {
                    echo 'Getting Project From Git'
                    checkout scm
                }
            }
        }

        stage('CLEAN') {
           steps {
              echo 'CLEANING PROJECT'
              sh 'mvn clean'
           }
        }

        stage('COMPILE AND PACKAGE') {
            steps {
                sh 'mvn package'
            }
        }

        stage('JUNIT/MOCKITO TEST') {
                steps {
                    sh 'mvn test'
                }
        }

        stage('SONARQUBE') {
            steps {
                withSonarQubeEnv('sonarqube_env') {
                    script {
                        echo 'SONARQUBE ANALYSIS'
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }

        stage('NEXUS') {
            steps {
                script {
                    echo 'Deploying to Nexus'
                    sh "mvn deploy -DskipTests"
                }
            }
        }

         stage('Build Docker Image Back-End et push sur DockerHub') {
             steps {
                 script {
                     def DOCKERHUB_USERNAME= "cyrinealoui"
                     def DOCKERHUB_TOKEN= "dckr_pat_vfTG20RYAQdxtCXFmEjRjDdv8MQ"
                     def imageName = "'${DOCKERHUB_USERNAME}'/devops-project-2.1:2.0.0"
                     def dockerfile = 'Dockerfile'

                     sh "docker login -u '${DOCKERHUB_USERNAME}' -p '${DOCKERHUB_TOKEN}'"

                     sh "docker build -t '$imageName' -f '$dockerfile' ."

                     sh "docker push '$imageName'"

                     sh "docker logout"
                 }
              }
             }

                     stage('Docker compose') {
                                 steps {
                                     sh 'docker-compose -f docker-compose.yml up -d --build'
                                 }
                             }



    }
}



