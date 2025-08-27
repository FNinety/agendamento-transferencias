<template>
  <el-card class="box-card" style="max-width: 800px; margin: 2rem auto;">
    <h2>Agendar Nova Transferência</h2>
    <el-form :model="form" @submit.prevent="agendarTransferencia" :rules="rules" ref="formRef">
      <el-form-item label="Conta de Origem">
        <el-input v-model="form.contaOrigem" maxlength="10" required />
      </el-form-item>
      <el-form-item label="Conta de Destino">
        <el-input v-model="form.contaDestino" maxlength="10" required />
      </el-form-item>
      <el-form-item label="Valor">
        <el-input v-model.number="form.valor" type="number" step="0.01" min="0.01" required />
      </el-form-item>
      <el-form-item label="Data da Transferência" prop="dataTransferencia">
        <el-date-picker v-model="form.dataTransferencia" type="date" required placeholder="Selecione a data" style="width:100%" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" native-type="submit">Agendar</el-button>
      </el-form-item>
    </el-form>
    <el-divider>Transferências Agendadas</el-divider>
    <el-table :data="transferencias" style="width: 100%">
      <el-table-column prop="contaOrigem" label="Origem"/>
      <el-table-column prop="contaDestino" label="Destino"/>
      <el-table-column prop="valor" label="Valor"/>
      <el-table-column prop="taxa" label="Taxa"/>
      <el-table-column prop="dataAgendamento" label="Data Agendamento"/>
      <el-table-column prop="dataTransferencia" label="Data Transferência"/>
    </el-table>
    <el-alert v-if="mensagemErro" :title="mensagemErro" type="error" show-icon style="margin-top:8px" />
  </el-card>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      transferencias: [],
      form: {
        contaOrigem: '',
        contaDestino: '',
        valor: '',
        dataTransferencia: ''
      },
      rules: {
      dataTransferencia: [
          { required: true, message: 'Data da transferência é obrigatória!', trigger: 'blur' }
        ]
      },
      mensagemErro: ''
    }
  },
  methods: {
    buscarTransferencias() {
      axios.get('http://localhost:8080/api/transferencias')
        .then(response => {
          this.transferencias = response.data;
        });
    },
    agendarTransferencia() {
      this.mensagemErro = '';
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8080/api/transferencias/agendar', {
            ...this.form
          })
          .then(() => {
            this.buscarTransferencias();
            this.form = { contaOrigem: '', contaDestino: '', valor: '', dataTransferencia: '' };
          })
          .catch(error => {
            if (error.response && error.response.data) {
              this.mensagemErro = error.response.data;
            } else {
              this.mensagemErro = 'Erro ao agendar transferência';
            }
          });
        }
      });
    }
  },
  mounted() {
    this.buscarTransferencias();
  }
}
</script>