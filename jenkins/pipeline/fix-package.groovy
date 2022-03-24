/**
 * This is pure Jenkins Pipeline syntax. Please keep it simple as there are many restrictions running a Groovy code as
 * Jenkins Pipeline, because of security reasons. If there is needed to put more complex Groovy code, make it as a
 * Gradle task and execute it into the pipeline.
 *
 * ----------- Prerequisite -----------
 * The job that runs this Jenkins pipeline code must be parametrised. The following parameters are required:
 * build_status (Choice Parameter) - Selects between the options 'milestone' or 'integration'. Usually when you build
 *                                   official fix package, 'milestone' option should be selected.
 * rebuild_fix (Boolean Parameter) - This is checkbox that sets whether the last fix will be rebuilt or a new fix will
 *                                   be built from release/<SAG_RELEASE>/master branch
 * node_name (String Parameter) - This is the name of the node on which has been ran BAM_BUILD_JOB
 *
 * There are some constants that have to be set according the jobs that build WMN-Shared component and Optimize
 * SAG_RELEASE - This is the release code
 * WMN_BUILD_JOB - This is the name of the job that builds WMN-Shared component
 * BAM_BUILD_JOB - This is the name of the job that builds Optimize
 * GITHUN_APP_ID - This is the ID of the GitHub App which has Read/Write access to AIM/optimize repository
 */

String SAG_RELEASE = '912oct2016'
String WMN_BUILD_JOB = "BAM-WMN_github_${SAG_RELEASE}_BAS_publish"
String BAM_BUILD_JOB = "BAM_github_${SAG_RELEASE}_BAS_CBMS_publish"
String BAM_BUILD_CODEBASE = '/opt/CBMS/source/' + BAM_BUILD_JOB
String GITHUB_APP_ID = 'github-app-IntegrationCore'
String CHECKOUT_REPO = 'https://github.com/VasilToshkov/Library.git'
def FIX_NUMBER = null

node("${node_name}") {
    stage('Checkout Base Workspace') {
        checkout([
                $class: 'GitSCM',
                branches: [
                        [name: "/master"]
                ],
                browser: [
                        $class: 'Stash',
                        repoUrl: CHECKOUT_REPO
                ],
                gitTool: 'Default'
        ])
        println"checkout"
    }
    // stage('Get Latest Fix Number') {
    //     jdk = tool name: 'java 1.8'
    //     env.JAVA_HOME = "${jdk}"

    //     withCredentials([usernamePassword(credentialsId: GITHUB_APP_ID,
    //             usernameVariable: 'GITHUB_APP',
    //             passwordVariable: 'GITHUB_ACCESS_TOKEN')]) {
    //         withGradle {
    //             sh "./gradlew storeLatestFixNumnerToPropFile -Drebuild_fix=${rebuild_fix} -DGITHUB_ACCESS_TOKEN=${GITHUB_ACCESS_TOKEN}"
    //         }

    //         def props = readProperties  file: 'fixes.property'

    //         FIX_NUMBER = props['FIX_NUMBER']
    //         if (FIX_NUMBER == null || FIX_NUMBER.isEmpty())
    //             throw new Exception('FIX_NUMBER property is missing')
    //     }
    // }
    // stage('Build WMN') {
    //     build job: WMN_BUILD_JOB, parameters: [
    //             string(name: 'bas.build.status', value: "${build_status}")
    //     ]
    // }
    // stage('Build BAM') {
    //     build job: BAM_BUILD_JOB, parameters: [
    //             string(name: 'bas.build.status', value: "${build_status}"),
    //             string(name: 'SANDBOX_NAME', value: "BAM_PI_${SAG_RELEASE}"),
    //             string(name: 'FIX_NUMBER', value: "${FIX_NUMBER}")
    //     ]
    // }
    // stage('Upload Fix Packages') {
    //     dir (BAM_BUILD_CODEBASE) {
    //         withGradle {
    //             sh "./gradlew uploadFixes --refresh-dependencies -Pbuild.patch=${FIX_NUMBER}"
    //         }
    //     }
    // }
    // stage('Tag the Build') {
    //     withCredentials([usernamePassword(credentialsId: GITHUB_APP_ID,
    //             usernameVariable: 'GITHUB_APP',
    //             passwordVariable: 'GITHUB_ACCESS_TOKEN')]) {
    //         dir (BAM_BUILD_CODEBASE) {
    //             withGradle {
    //                 sh "./gradlew createOrMoveTag -Pbuild.patch=${FIX_NUMBER} -DGITHUB_ACCESS_TOKEN=${GITHUB_ACCESS_TOKEN}"
    //             }
    //         }
    //     }
    // }
}