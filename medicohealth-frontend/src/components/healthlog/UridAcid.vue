<!--尿酸-->
<template>
    <div id="container9" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container9'));   
        let option = {
            title: {
                text: '尿酸值统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['尿酸']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['2018-10-12','2018-10-16','2019-01-12','2019-02-06','2019-02-12','2019-02-17','2019-02-22']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'尿酸',
                    type:'line',
                    stack: '总量',
                    data:[345, 350, 347, 347, 351, 355, 380]
                },
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>