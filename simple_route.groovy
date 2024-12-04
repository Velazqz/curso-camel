@GrabConfig(systemClassLoader = true)
@Grapes([
	@Grab(group = 'org.apache.camel', module = 'camel-core', version = '4.0.1'),
	@Grab(group = 'ch.qos.logback', module = 'logback-classic', version = '1.5.12', scope = 'test')
])
import org.apache.camel.CamelContext
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.impl.DefaultCamelContext

CamelContext context = new DefaultCamelContext()

println "Comienza Camel Context"

context.addRoutes(new RouteBuilder() {
	@Override
	void configure() throws Exception {
		from("file:input")
			.setBody(body().append("${new Date()}"))
			.to("file://output")
	}
})

context.start()
Thread.sleep(5000)
context.stop()

println "Termina Camel Context"
