#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend(message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful")
    //slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend(message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed")
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend(message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable")
  }
  else {
    slackSend(message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its result was unclear")
  }
}
