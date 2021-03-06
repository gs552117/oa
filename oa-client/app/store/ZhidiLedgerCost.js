Ext.define('oa.store.ZhidiLedgerCost', {
    extend: 'Ext.data.Store',

    id: 'store.zhidiLedgerCost',
    alias: 'store.zhidiLedgerCost',

    model: 'oa.model.ZhidiLedgerCost',
    remoteFilter: true,
    proxy: {

        type: 'ajax',
        url: oa.config.Config.BASE_URL + 'ledger/zhidi/cost/list',
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'totalCount'
        }
    }
});