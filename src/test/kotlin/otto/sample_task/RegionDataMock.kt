package otto.sample_task

import otto.sample_task.data.Data

class RegionDataMock : Data {
    override fun requestData(): Data.RegionMeta {

        val prefixes = arrayListOf(
            Data.Region("127.0.0.1", "ap-northeast-2", "AMAZON", "ap-northeast-2"),
            Data.Region("127.0.0.2", "ap-northeast-2", "AMAZON", "ap-northeast-2"),
            Data.Region("127.0.0.2", "eu-west-2", "AMAZON", "eu-west-2")
        )

        return Data.RegionMeta("17.05.2022",    "17.05.2022", prefixes)
    }
}