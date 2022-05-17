package otto.sample_task.controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RegionController {
    @GetMapping("/")
    fun helloKotlin(): String {
        return "Home Screen"
    }
}