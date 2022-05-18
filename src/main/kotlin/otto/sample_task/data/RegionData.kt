package otto.sample_task.data

interface RegionData {
    data class RegionMeta(val syncToken: String, val createDate: String, val prefixes: ArrayList<Region>)
    data class Region(val ip_prefix: String, val region: String, val service: String, val network_border_group: String)
    fun requestData(): RegionMeta
}