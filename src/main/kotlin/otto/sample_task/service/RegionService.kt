package otto.sample_task.service
import org.springframework.stereotype.Service
import otto.sample_task.data.Data


/**
 * This service is responsible for filtering ip-data.
 */
@Service
class RegionService(private val data: Data) {
    val validRegions = listOf("eu", "us", "ap", "cn", "sa", "af", "ca")
    val allRegion = "all"

    /**
     * validate region
     */
    fun isValid(region: String): Boolean {
        return validRegions.contains(region)
    }

    /**
     * filter by one region
     */
    fun getData(region: String): ArrayList<Data.Region> {
        val result = ArrayList<Data.Region>()
        val regionMeta = data.requestData()
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
    fun getData(): ArrayList<Data.Region> {
        val result = ArrayList<Data.Region>()
        val regionMeta = data.requestData()
        for (reg in regionMeta.prefixes) {

            if (isValid(reg.region.substring(0, 2))) {
                result.add(reg)
            }
        }

        return result;
    }
}