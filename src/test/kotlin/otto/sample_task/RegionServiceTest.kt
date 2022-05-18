package otto.sample_task

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import otto.sample_task.service.RegionService

class RegionServiceTest {
    private val regionService: RegionService = RegionService(RegionRegionDataMock());

    @Test
    fun find_eu() {
        val result = regionService.getData("eu")
        Assertions.assertEquals("eu-west-2", result[0].region)
    }

    @Test
    fun find_ap() {
        val result = regionService.getData("ap")
        Assertions.assertEquals("ap-northeast-2", result[0].region)
        Assertions.assertEquals(2, result.size)
    }

    @Test
    fun valid_region() {
        val result = regionService.isValid("is")
        Assertions.assertEquals(false, result)
    }
}