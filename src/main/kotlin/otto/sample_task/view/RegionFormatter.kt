package otto.sample_task.view

import otto.sample_task.service.RegionService


class RegionFormatter {

    companion object {
        fun format(regionList: ArrayList<RegionService.Region>): String {
            var result = ""
            for (reg in regionList) {
                result += reg.ip_prefix + " " + reg.region + " " + reg.service + " " + reg.network_border_group + "\n"
            }

            return result
        }
    }
}