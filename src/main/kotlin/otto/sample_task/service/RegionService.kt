package otto.sample_task.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import otto.sample_task.data.RegionData


/**
 * This service is responsible for filtering ip-data.
 */
@Service
class RegionService(private val regionData: RegionData) {
    // val validRegions = listOf("eu", "us", "ap", "cn", "sa", "af", "ca")
    @Value("\${region.valid.ranges}")
    val validRegions: List<String> = listOf()

    @Value("\${region.valid.ranges.all}")
    val allRegion: String = ""

    /**
     * validate region
     */
    fun isValid(region: String): Boolean {
        return validRegions.contains(region)
    }

    /**
     * filter by one region
     */
    fun getData(region: String): ArrayList<RegionData.Region> {
        val result = ArrayList<RegionData.Region>()
        val regionMeta = regionData.requestData()
        for (reg in regionMeta.prefixes) {
            if (reg.region.substring(0, 2) == region) {
                result.add(reg)
            }
        }

        return result;
    }

    /**
     * filter by all valid regions
     */
    fun getData(): ArrayList<RegionData.Region> {
        val result = ArrayList<RegionData.Region>()
        val regionMeta = regionData.requestData()
        for (reg in regionMeta.prefixes) {

            if (isValid(reg.region.substring(0, 2))) {
                result.add(reg)
            }
        }

        return result;
    }
}