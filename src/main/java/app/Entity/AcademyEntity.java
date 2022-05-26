package app.Entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity(name = "academy")
@Table(name = "academy")
public class AcademyEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String ATPT_OFCDC_SC_CODE;
    @Column
    private String ATPT_OFCDC_SC_NM;
    @Column
    private String ADMST_ZONE_NM;
    @Column(name = "ACA_INSTI_SC_NM")
    private String ACA_INSTI_SC_NM;
    @Column
    private Long ACA_ASNUM;
    @Column(name = "ACA_NM")
    private String ACA_NM;
    @Column
    private int ESTBL_YMD;
    @Column
    private int REG_YMD;
    @Column
    private String REG_STTUS_NM;
    @Column
    private String CAA_BEGIN_YMD;
    @Column
    private String CAA_END_YMD;
    @Column
    private int TOFOR_SMTOT;
    @Column
    private int DTM_RCPTN_ABLTY_NMPR_SMTOT;
    @Column
    private String REALM_SC_NM;
    @Column
    private String LE_ORD_NM;
    @Column
    private String LE_CRSE_LIST_NM;
    @Column
    private String LE_CRSE_NM;
    @Column
    private String PSNBY_THCC_CNTNT;
    @Column
    private String THCC_OTHBC_YN;
    @Column
    private String BRHS_ACA_YN;
    @Column
    private int FA_RDNZC;
    @Column
    private String FA_RDNMA;
    @Column
    private String FA_RDNDA;
    @Column
    private int LOAD_DTM;

}