@Grapes(
    @Grab(group='org.apache.camel', module='camel-core', version='4.0.1')
        @Grab(group='ch.qos.logback', module='logback-classic', version='1.5.12', scope='test')

)
import org.apache.camel.CamelContext
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.builder.RouteBuilder

CamelContext context = new DefaultCamelContext()

println "Comienza camel context"

//context.addRoutes()

context.start()
Thread.sleep(5000)
context.stop

println "Termina camel context"

