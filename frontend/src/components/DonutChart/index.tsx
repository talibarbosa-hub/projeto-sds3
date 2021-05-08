import axios from 'axios';
import { type } from 'node:os';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    //  sem Hooks requisição e tratamento de dados
    let chartData : ChartData = {labels:[], series:[]}; // inicia com lista vazia

    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response=> {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map (x => x.sum );

            chartData = {labels: myLabels, series: mySeries};
            console.log(chartData);
        });



    
    //mock
    /*const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }*/
    
    const options = {
        legend: {
            show: true
        }
    };
        return (
            <Chart
                options={{...options, labels: chartData.labels}}  // pega o objeto options e inclui
                series={chartData.series}
                type="donut"
                height="240"

            />
    );
}

export default DonutChart;