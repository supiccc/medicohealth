<!--身高体重-->
<template>
    <div id="container8" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container8'));   
        let option = {
            title: {
                text: '身高体重统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['身高(cm)', '体重(kg)', 'BMI']
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
                    name:'身高(cm)',
                    type:'line',
                    stack: '总量',
                    data:[180.0, 180.1, 180.2, 180.0, 180.1, 180.3, 180.2]
                },
                {
                    name:'体重(kg)',
                    type:'line',
                    stack: '总量',
                    data:[80, 78, 79, 80, 82, 83, 85]                    
                },
                {
                    name:'BMI',
                    type:'line',
                    stack: '总量',
                    data:[23.2, 22.7, 23.0, 23.2, 23.8, 24.1, 25.3]                    
                }
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>