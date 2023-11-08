pipeline {
    agent any

    environment {
            DOCKERHUB_USERNAME = credentials('cyrinealoui')
            DOCKERHUB_TOKEN = credentials('dckr_pat_vfTG20RYAQdxtCXFmEjRjDdv8MQ')
            IMAGE_NAME = "${DOCKERHUB_USERNAME}/devops-project-2.1:2.0.0.jar"
            DOCKERFILE = 'Dockerfile'
        }

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

         stage('BUILD DOCKER IMAGE') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME} -f ${DOCKERFILE} ."
                }
            }
         }

         stage('PUSH DOCKER IMAGE') {
            steps {
                script {
                    sh "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_TOKEN}"
                    sh "docker push ${IMAGE_NAME}"
                }
            }
         }


    }
}


