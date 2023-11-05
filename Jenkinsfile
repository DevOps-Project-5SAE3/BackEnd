pipeline {
agent any

stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the repository
                    checkout scm
                }
            }
        }
 stage('Clean and compile') {
            steps {
                sh "mvn clean"
                sh "mvn compile"
                sh "mvn package"
            }
        }

stage('tests JUnit ici avec Mockito') {
            steps {
                sh "mvn test"  // Exécutez vos tests JUnit ici avec Mockito

                sh "mvn jacoco:report"
            }
        }

stage('SonarQube') {
            steps {
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
            }
        }


stage('Deploy to Nexus') {
            steps {
                sh "mvn deploy"
            }
        }

stage('Build Docker Image Back-End et push sur DockerHub') {
    steps {
        script {
            def DOCKERHUB_USERNAME= "fatmambarek"
            def DOCKERHUB_TOKEN= "dckr_pat_ETmO43yEKMowkb4Gspf-dAn8wNQ"
            def imageName = "'${DOCKERHUB_USERNAME}'/back-end:2.0.0"
            def dockerfile = 'Dockerfile'

            // Se connecter à Docker Hub
            sh "docker login -u '${DOCKERHUB_USERNAME}' -p '${DOCKERHUB_TOKEN}'"

            // Build de l'image Docker
            sh "docker build -t '$imageName' -f '$dockerfile' ."

            // Push de l'image Docker vers Docker Hub
            sh "docker push '$imageName'"

            // Déconnexion de Docker Hub
            sh "docker logout"
        }
     }
    }


}
}