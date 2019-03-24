<!--脂肪-->
<template>
    <div id="container7" style="height: 100%; margin: 10px 10px 10px 10px;">
    </div>
</template>
<script>
import echarts from 'echarts'
export default {
    data() {
        return {   }
    },
    mounted() {
        let myChart = echarts.init(document.getElementById('container7'));   
        let option = {
            title: {
                text: '用户统计'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['脂肪', '基础代谢率', '水分含量']
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
                    name:'脂肪',
                    type:'line',
                    stack: '总量',
                    data:[26.8, 25.8, 26.6, 24.6, 28.8, 27.8, 25.5]
                },
                {
                    name:'基础代谢率',
                    type:'line',
                    stack: '总量',
                    data:[1189, 1182, 1191, 1134, 1190, 1130, 1210]                    
                },
                {
                    name:'水分含量',
                    type:'line',
                    stack: '总量',
                    data:[56, 55, 53, 58, 59, 57, 58]
                },                
            ]
        };
        if (option && typeof option === "object") {
           myChart.setOption(option, true);
        };
    }
}
</script>