package otto.sample_task

import otto.sample_task.data.RegionData

class RegionDataMock : RegionData {
    override fun requestData(): RegionData.RegionMeta {

        val prefixes = arrayListOf(
            RegionData.Region("127.0.0.1", "ap-northeast-2", "AMAZON", "ap-northeast-2"),
            RegionData.Region("127.0.0.2", "ap-northeast-2", "AMAZON", "ap-northeast-2"),
            RegionData.Region("127.0.0.2", "eu-west-2", "AMAZON", "eu-west-2")
        )

        return RegionData.RegionMeta("17.05.2022",    "17.05.2022", prefixes)
    }
}