pipeline {
    agent any
    stages {

        stage('Checkout') {
                steps {
                    // Étape pour récupérer le code source depuis le référentiel Git
                    checkout([$class: 'GitSCM', branches: [[name: '*/bougacha']], userRemoteConfigs: [[url: 'https://github.com/DevOps-Project-5SAE3/BackEnd.git']]])
                }
            }
            stage('Build') {
                steps {
                    script{
                        sh 'mvn --version'
                        sh 'mvn clean package -DiskpTests'
                    }
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
            }

            stage('Run Sonar')  {
                        steps {
                            withCredentials([string(credentialsId: 'sonar', variable: 'SONAR_TOKEN')]) {
                                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.33.10:9000/ -Dsonar.login=$SONAR_TOKEN'
                            }
                        }
                    }


          stage("Deploy Artifact to Nexus") {
            steps {
                sh "mvn deploy -DskipTests"
            }
        }

        stage('Building Docker image') {
                	   steps {
                		 script {
                			// Generating image from Dockerfile
                			  sh 'docker build -t bougacha10/devops_project_2.1.jar .'
                			}
                		 }
                	    }

        stage('Docker Hub') {
                    steps {
                     script {
                    // Define your Docker access token
                          def dockerAccessToken = 'dckr_pat_OilxKdqMBcYlEt1aesNuW2oQxvM'

                    // Log in to Docker Hub with --password-stdin
                            sh "echo '${dockerAccessToken}' | docker login -u bougacha10 --password-stdin"
                    // Tag and push the Docker image

                            sh "docker push bougacha10/devops_project_2.1.jar"
                    }
                    }
                }
                stage('tests JUnit ici avec Mockito') {
                            steps {
                                sh "mvn test"  // Exécutez vos tests JUnit ici avec Mockito

                                sh "mvn jacoco:report"
                            }
                        }

        stage('docker comose') {
            steps {
                sh "cd  /var/lib/jenkins/workspace/Ahmed_BOUGACHA_5SAE3/target"
                sh "docker compose up -d"
            }
        }




    }
    }