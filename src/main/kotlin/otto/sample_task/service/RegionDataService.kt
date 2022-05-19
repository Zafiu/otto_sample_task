package otto.sample_task.service

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import otto.sample_task.data.RegionData
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
/**
 * This service is responsible for requesting and parsing ip-data.
 */
class RegionDataService: RegionData {

    @Value("\${aws.address}")
    private val address: String = ""
    override fun requestData(): RegionData.RegionMeta {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build();
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return Gson().fromJson(response.body(), RegionData.RegionMeta::class.java);
    }
}