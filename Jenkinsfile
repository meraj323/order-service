pipeline {
    agent any 
    stages {
        stage('Checkout code') {
        steps {
            checkout scm
            }
        }
        stage('Build') { 
            steps {
               echo 'build started!!'
               sh "./mvnw clean install -DskipTests"   
            }
        }
        stage('Test') { 
            steps {
                echo 'test started!!'   
            }
        }
        stage('Deploy') { 
            steps {
                echo 'test started!!'
            }
        }
    }
}
