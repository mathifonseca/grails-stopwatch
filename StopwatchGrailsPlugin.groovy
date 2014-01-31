class StopwatchGrailsPlugin {
    def version = "0.0.1"
    def grailsVersion = "2.0 > *"
    def title = "Stopwatch Plugin" // Headline display name of the plugin
    def author = "Mathias Fonseca"
    def authorEmail = "mathifonseca@gmail.com"
    def description = "This plugin adds a stopwatch property to Grails artifacts to help you measure ellapsed time between tasks."
    def documentation = "http://grails.org/plugin/stopwatch"
    def license = "APACHE"
    def issueManagement = [ system: "GITHUB", url: "https://github.com/mathifonseca/grails-stopwatch/issues" ]
    def scm = [ url: "https://github.com/mathifonseca/grails-stopwatch" ]

    def doWithSpring = {
        application.controllerClasses.each {
            if (!it.hasProperty('stopwatch')) {
                it.metaClass.stopwatch = new org.springframework.util.StopWatch()
            }
        }
        application.serviceClasses.each {
            if (!it.hasProperty('stopwatch')) {
                it.metaClass.stopwatch = new org.springframework.util.StopWatch()
            }
        }
    }

}