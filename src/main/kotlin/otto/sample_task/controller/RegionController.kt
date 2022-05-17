package otto.sample_task.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import otto.sample_task.data.RegionData
import otto.sample_task.view.RegionFormatter
import otto.sample_task.service.RegionService

@RestController
class RegionController(private val regionService: RegionService) {


    @GetMapping("/")
    fun helloKotlin(): String {
        return "example how to request data: region/region=e"
    }

    @GetMapping("/region", produces = [org.springframework.http.MediaType.TEXT_PLAIN_VALUE])
    fun region(@RequestParam region: String): String {
        val reg = region.lowercase()
        val result: ArrayList<RegionData.Region> = if (regionService.allRegion == reg) {
            regionService.getData()

        } else if (regionService.isValid(reg)) {
            regionService.getData(reg)
        } else {
            return "Region is not valid!"
        }

        return RegionFormatter.format(result)
    }
}