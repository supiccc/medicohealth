<template>
    <div id="container2" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container2'));   
        let option = {
            title: {
                text: '用户统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['医师', '老人']
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
                data: ['2019-02-20','2019-03-25','2019-03-25']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'老人',
                    type:'line',
                    stack: '总量',
                    data:[1, 1, 1]
                },
                {
                    name:'医师',
                    type:'line',
                    stack: '总量',
                    data:[0, 1, 2]                    
                }
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>