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
               sh "mvn spring-boot:run"   
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
