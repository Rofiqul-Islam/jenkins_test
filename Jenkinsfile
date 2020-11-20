pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn compile'
                }
            }
        }

        stage ('Authentication Stage') {
            steps {
                input("Do you want to proceed?")
            }
        }

        stage ('Testing Stage') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn test'
                }
            }
        }

        stage ('Email') {
            steps {
                emailext body: 'Now', subject: 'Test', to: 'shourav95.ri@gmail.com'
            }
        }


    }