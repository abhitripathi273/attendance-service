pipeline {
    agent any
    tools {
        maven '3.9.1'
        jdk "JDK"
    }
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
    }
    stages {
	
	stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
	stage('Build') {
            steps {
                dir("/var/jenkins_home/workspace/attendance-service_master") {
                sh 'mvn -B -DskipTests clean package'
                }
            }
        }	
    stage('Docker Build') {
            steps {
                script {
                    docker.build("abhitripathi273/attendance-service:${TAG}")
                }
            }
        }
	stage('Pushing Docker Image to Dockerhub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_credential') {
                        docker.image("abhitripathi273/attendance-service:${TAG}").push()
                        docker.image("abhitripathi273/attendance-service${TAG}").push("latest")
                    }
                }
            }
        }
    stage('Deploy'){
            steps {
                sh "docker stop attendance-service| true"
                sh "docker rm attendance-service | true"
                sh "docker run --name attendance-service -d -p 8081:8080 abhitripathi273/attendance-service:${TAG}"
            }
        }
    }
}
