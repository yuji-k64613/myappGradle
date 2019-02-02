pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'build/libs/**/*.war', fingerprint: true
            archiveArtifacts artifacts: './Jenkinsfile'
        }
    }
}
