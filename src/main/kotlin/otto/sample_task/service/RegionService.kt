package otto.sample_task.service

import com.google.gson.Gson
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/**
 * This service is responsible for requesting, parsing and also filtering ip-data.
 */
@Service
class RegionService {
    data class RegionMeta(val syncToken: String, val createDate: String, val prefixes: ArrayList<Region>)
    data class Region(val ip_prefix: String, val region: String, val service: String, val network_border_group: String)

    private val address: String = "https://ip-ranges.amazonaws.com/ip-ranges.json"
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
    fun getData(region: String): ArrayList<Region> {
        val result = ArrayList<Region>()
        val regionMeta = requestData()
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
    fun getData(): ArrayList<Region> {
        val result = ArrayList<Region>()
        val regionMeta = requestData()
        for (reg in regionMeta.prefixes) {

            if (isValid(reg.region.substring(0, 2))) {
                result.add(reg)
            }
        }

        return result;
    }

    private fun requestData(): RegionMeta {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return Gson().fromJson(response.body(), RegionMeta::class.java);
    }
}