<!--胆固醇-->
<template>
    <div id="container6" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container6'));   
        let option = {
            title: {
                text: '胆固醇值统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['胆固醇']
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
                    name:'胆固醇',
                    type:'line',
                    stack: '总量',
                    data:[4.5, 5.1, 4.7, 4.9, 5.6, 5.3, 5.9]
                }
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>