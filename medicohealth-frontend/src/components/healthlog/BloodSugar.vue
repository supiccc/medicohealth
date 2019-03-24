<!--血糖-->
<template>
    <div id="container5" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container5'));   
        let option = {
            title: {
                text: '血糖统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['血糖值']
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
                    name:'血糖值',
                    type:'line',
                    stack: '总量',
                    data:[4.0, 3.9, 5.5, 6.7, 6.1, 4.7, 5.8]
                },
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>