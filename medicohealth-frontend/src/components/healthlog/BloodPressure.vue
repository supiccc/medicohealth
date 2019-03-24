<!--血压-->
<template>
    <div id="container4" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container4'));   
        let option = {
            title: {
                text: '血压统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['舒张压(mmHg)', '收缩压(mmHg)', '脉搏']
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
                    name:'舒张压(mmHg)',
                    type:'line',
                    stack: '总量',
                    data:[67, 88, 76, 88, 95, 92, 89]
                },
                {
                    name:'收缩压(mmHg)',
                    type:'line',
                    stack: '总量',
                    data:[120, 126, 130, 100, 156, 160, 145]                    
                },
                {
                    name:'脉搏',
                    type:'line',
                    stack:'总量',
                    data:[66, 63, 71, 54, 66, 35, 67]
                }
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>