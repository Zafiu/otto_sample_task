package otto.sample_task.data

import com.google.gson.Gson
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
/**
 * This service is responsible for requesting and parsing ip-data.
 */
class RegionData: Data {
    data class RegionMeta(val syncToken: String, val createDate: String, val prefixes: ArrayList<Region>)
    data class Region(val ip_prefix: String, val region: String, val service: String, val network_border_group: String)
    private val address: String = "https://ip-ranges.amazonaws.com/ip-ranges.json"

    override fun requestData(): RegionMeta {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return Gson().fromJson(response.body(), RegionMeta::class.java);
    }
}